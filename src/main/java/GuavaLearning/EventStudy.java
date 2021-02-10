package GuavaLearning;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * @author limengtong
 * @date 2021/2/10 5:22 下午
 */
// EventBus是事件中央处理器，可以全局唯一，也可以模块唯一
public class EventStudy {
    public static void main(String args[]) {
        EventBus eventBus = new EventBus("test");
        // 注册监听者
        eventBus.register(new OrderEventListener());
        // 发布消息
        eventBus.post(new OrderMessage("lllllllll"));
    }
}

class OrderEventListener {

    /**
     * 如果发送了OrderMessage消息，会进入到该函数的处理
     * @param event 消息
     */
    @Subscribe
    public void dealWithEvent(OrderMessage event) {
        // TODO: 收到EventTest消息之后，做相应的处理
        System.out.println("我收到了您的命令，命令内容为：" + event.getOrderContent());
    }

}

/**
 * 命令对应的内容
 */
class OrderMessage {
    private String orderContent;

    public OrderMessage(String orderContent) {
        this.orderContent = orderContent;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }
}
