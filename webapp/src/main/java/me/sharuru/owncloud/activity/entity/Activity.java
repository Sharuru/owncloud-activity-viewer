package me.sharuru.owncloud.activity.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

/**
 * Created by Sharuru on 2017/2/11 0011.
 */
@Entity
@Table(name = "oc_activity")
@Data
public class Activity implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    @Id
    @Column(name = "activity_id", unique = true)
    @JsonView(DataTablesOutput.View.class)
    private Long id;

    @JsonView(DataTablesOutput.View.class)
    private Long timestamp;

    private Long priority;

    @JsonView(DataTablesOutput.View.class)
    private String type;

    @JsonView(DataTablesOutput.View.class)
    private String user;

    @JsonView(DataTablesOutput.View.class)
    private String affecteduser;

    @JsonView(DataTablesOutput.View.class)
    private String app;

    @JsonView(DataTablesOutput.View.class)
    private String subject;

    private String subjectparams;

    private String message;

    private String messageparams;

    @JsonView(DataTablesOutput.View.class)
    private String file;

    @JsonView(DataTablesOutput.View.class)
    private String link;

    @Column(name = "object_type")
    @JsonView(DataTablesOutput.View.class)
    private String objectType;

    @Column(name = "object_id")
    @JsonView(DataTablesOutput.View.class)
    private Long objectId;
}

