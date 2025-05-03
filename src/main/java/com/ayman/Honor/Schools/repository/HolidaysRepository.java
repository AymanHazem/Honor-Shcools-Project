package com.ayman.Honor.Schools.repository;
import com.ayman.Honor.Schools.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HolidaysRepository extends CrudRepository <Holiday,String>
{

}
