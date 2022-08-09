package mobi.ms3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mobi.ms3.enums.Ms;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    private String id;
    private String body;
    private Ms source;
    private Ms destination;
}
