package mobi.ms3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mobi.ms3.enums.Ms;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceivedMessage {
    private String id;
    private String reachingMsg;
}
