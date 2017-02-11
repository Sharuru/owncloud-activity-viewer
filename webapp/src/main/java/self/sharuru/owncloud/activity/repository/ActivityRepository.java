package self.sharuru.owncloud.activity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import self.sharuru.owncloud.activity.entity.Activity;

/**
 * Created by Sharuru on 2017/2/11 0011.
 */
@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long>{

    Page<Activity> findAllByOrderByIdDesc(Pageable pageable);


}
