package com.zero.qsonline.entity;

import lombok.*;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_dept")
public class Dept extends Model<Dept> {

private static final long serialVersionUID=1L;

                    @TableId(value = "dept_id", type = IdType.UUID)
                private String deptId;
    /**
     * 系名称
     */
        private String detpName;


    /**
     * 
     */
    public static final String DEPT_ID ="dept_id";

    /**
     * 系名称
     */
    public static final String DETP_NAME ="detp_name";

@Override
protected Serializable pkVal(){
            return this.deptId;
        }

        }
