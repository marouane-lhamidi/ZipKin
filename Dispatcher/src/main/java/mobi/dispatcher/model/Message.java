package mobi.dispatcher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mobi.dispatcher.enums.Ms;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String id;
    private String body;
    private Ms source;
    private Ms destination;
//    private int counter;
}
