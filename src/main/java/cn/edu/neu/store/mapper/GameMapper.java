package cn.edu.neu.store.mapper;

import cn.edu.neu.store.model.Games;
import cn.edu.neu.store.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameMapper {

    List<Games> getGameList(Games game);

    boolean addGame(Games game);

    boolean deleteGame(Games game);

    Games getGame(String gameid);

    void updateGame(Games game);
    List<Games> getEcharts(Games game);

    String countByPla(String g_platform);

}
