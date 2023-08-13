package daily.test;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/1/4 5:28 PM
 * @Version 1.0
 */
@ToString(callSuper = true)
@Data
public class ReceiveReq{
    /**
     * 活动code
     */
    private String activityCode;


    public static void main(String[] args) {
        ReceiveReq receiveReq = new ReceiveReq();
        receiveReq.setActivityCode("2111897243376058986");
        System.out.println(receiveReq);
    }
}
