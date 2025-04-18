package me.sharuru.owncloud.activity.repository;

import me.sharuru.owncloud.activity.entity.Activity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

/**
 * Created by Sharuru on 2017/2/11 0011.
 */
public interface ActivityRepository extends DataTablesRepository<Activity, Long> {

}
