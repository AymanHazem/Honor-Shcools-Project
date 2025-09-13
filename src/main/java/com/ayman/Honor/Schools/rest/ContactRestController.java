package com.ayman.Honor.Schools.rest;
import com.ayman.Honor.Schools.constants.HonorSchoolConstants;
import com.ayman.Honor.Schools.model.Contact;
import com.ayman.Honor.Schools.model.ResponseMsg;
import com.ayman.Honor.Schools.repository.ContactRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(path = "/api/contact")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ContactRestController
{
    private final ContactRepository contactRepository;


    @GetMapping("/getMessagesByStatus")
    public List<Contact> getMessagesByStatus (@RequestParam(name = "status")  String status)
    {
        return contactRepository.getByStatus(status);
    }

    @GetMapping("/getAllMsgsByStatus")
    public List<Contact> getAllMsgsByStatus(@RequestBody Contact contact)
    {
        if(null != contact && null != contact.getStatus())
            return contactRepository.getByStatus(contact.getStatus());
        else
            return List.of();
    }

    @PostMapping("/saveMsg")
    public ResponseEntity<ResponseMsg> saveMsg (@RequestHeader("invocationFrom") String invocationFrom , @Valid @RequestBody Contact contact)
    {
        log.info(String.format("Header invocationFrom = %s", invocationFrom));
        contactRepository.save(contact);
        ResponseMsg response = new ResponseMsg();
        response.setStatusCode("200");
        response.setStatusMsg("Message saved successfully");
        return ResponseEntity.status(HttpStatus.CREATED).header("isMsgSaved" , "true").body(response);
    }

    @DeleteMapping("/deleteMsg")
    public ResponseEntity<ResponseMsg> deleteMsg(RequestEntity<Contact> requestEntity)
    {
        HttpHeaders headers = requestEntity.getHeaders();
        headers.forEach((key, value) ->
        {
            log.info(String.format("Header '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));
        });
        contactRepository.deleteById(requestEntity.getBody().getContactId());
        ResponseMsg response = new ResponseMsg();
        response.setStatusCode("200");
        response.setStatusMsg("Message successfully deleted");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/closeMsg")
    public ResponseEntity<ResponseMsg> closeMsg(@RequestBody Contact contactReq)
    {
        ResponseMsg response = new ResponseMsg();
        Optional<Contact> contact = contactRepository.findById(contactReq.getContactId());
        if (contact.isPresent())
        {
            contact.get().setStatus(HonorSchoolConstants.CLOSE);
            contactRepository.save(contact.get());
        }
        else
        {
            response.setStatusCode("400");
            response.setStatusMsg("Invalid Contact ID received");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);

        }

        response.setStatusCode("200");
        response.setStatusMsg("Message successfully closed");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
