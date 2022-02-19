package top.jrl.springbucks.jpademo.model;

public enum OrderState {
    /**
     * 新增
     */
    INIT,
    /**
     * 支付完成
     */
    PAID,
    /**
     * 制作中
     *
     * @author jrl
     * @date 2022/2/19
     */
    BREWING,
    /**
     * 制作好了
     *
     * @author jrl
     * @date 2022/2/19
     */
    BREWED,
    /**
     * 给客人了
     *
     * @author jrl
     * @date 2022/2/19
     */
    TAKEN,
    /**
     * 取消订单
     */
    CANCELLED
}
