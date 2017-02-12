package self.sharuru.owncloud.activity.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import self.sharuru.owncloud.activity.entity.Activity;

/**
 * Created by Sharuru on 2017/2/11 0011.
 */
public interface ActivityRepository extends DataTablesRepository<Activity, Long> {

}
