package top.jrl.springbucks.jpademo.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 咖啡
 *
 * @author Joly
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
/**  在继承父类情况下，配合Data注解*/
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "T_MENU")
@Entity
public class Coffee extends BaseEntity {


    private String name;
    /**
     * 用于想jpa说明Money这个类型如何映射，因为Money不是JDK里的，是其他jar包里的
     */
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount",
            parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money price;

}

