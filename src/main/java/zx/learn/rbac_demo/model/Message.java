package zx.learn.rbac_demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

    Integer messageId;
    String title;
    String detail;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createTime;

    String createTimeStr;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime editTime;
    Integer userId;

}
