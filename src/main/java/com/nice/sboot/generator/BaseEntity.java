//
//import com.baomidou.mybatisplus.annotation.*;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import io.swagger.v3.oas.annotations.media.Schema;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
///**
// * @author 罗勇
// * @date 2022/1/17
// */
//@Getter
//@Setter
//@ToString
//@Schema(description = "BaseEntity")
//public class BaseEntity implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	@Schema(description = "主键")
//	@TableId(value = "id", type = IdType.AUTO)
//	private Integer id;
//
//	@Schema(description = "0-正常、1-删除")
//	@TableLogic(value = "0", delval = "1")
//	@TableField(fill = FieldFill.INSERT)
//	private Integer delFlag;
//
//	@Schema(description = "createBy")
//	@TableField(fill = FieldFill.INSERT)
//	private String createBy;
//
//	@Schema(description = "创建时间")
//	@TableField(fill = FieldFill.INSERT)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//	private LocalDateTime createTime;
//
//	@Schema(description = "updateBy")
//	@TableField(fill = FieldFill.INSERT_UPDATE)
//	private String updateBy;
//
//	@Schema(description = "修改时间")
//	@TableField(fill = FieldFill.INSERT_UPDATE)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//	private LocalDateTime updateTime;
//}