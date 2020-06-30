package lu.eyet.dev.jdbcsandbox.model;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public abstract class AuditModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @CreatedDate
    private DateTime createDate;

    @LastModifiedDate
    private DateTime lastModifiedDate;

}