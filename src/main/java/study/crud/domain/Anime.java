package study.crud.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Anime {
    Integer id;
    String name;
    int episodes;
    Producer producer;
}
