package model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PlayList {

    private List<Song> playlist;

}
