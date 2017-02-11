package self.sharuru.owncloud.activity.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sharuru on 2017/2/11 0011.
 */
@Entity
@Table(name = "oc_activity")
@Data
public class Activity {

    private static final long serialVersionUID = -1L;

    @Id
    @Column(name = "activity_id", unique = true)
    private Long id;

    private Long timestamp;

    private Long priority;

    private String type;

    private String user;

    private String affecteduser;

    private String app;

    private String subject;

    private String subjectparams;

    private String message;

    private String messageparams;

    private String file;

    private String link;

    @Column(name = "object_type")
    private String objectType;

    @Column(name = "object_id")
    private String objectId;
}

