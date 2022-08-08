package mobi.dispatcher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceivedMessage {
    private String id;
    private String reachingMsg;
//    private Ms source;
//    private Ms dst;
}
