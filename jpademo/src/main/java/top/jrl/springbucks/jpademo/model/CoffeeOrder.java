package top.jrl.springbucks.jpademo.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Table(name = "T_ORDER")
@Entity
public class CoffeeOrder extends BaseEntity {

    @JoinTable(name = "T_ORDER_COFFEE")
    @ManyToMany
    private List<Coffee> items;

    private String customer;

    @Column(nullable = false)
    private OrderState State;


}
