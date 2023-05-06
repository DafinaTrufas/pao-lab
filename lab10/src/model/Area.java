package model;

import lombok.Builder;
import lombok.Getter;

import java.util.Iterator;
import java.util.List;

@Builder
@Getter
public class Area {

    private List<TreasureChest> treasureChests;

}
