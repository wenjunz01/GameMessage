package cn.edu.neu.store.service;

import cn.edu.neu.store.model.Games;
import cn.edu.neu.store.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface GameService {

    List<Games> getGameList(Games game);

    int addGame (Games game);

    boolean deleteGame(Games game);

    List<Games> getEcharts(Games game);

    Games getGame(String gameid);

    boolean updateGame(Games game);

    Map<String, String> getGamePla();


}
