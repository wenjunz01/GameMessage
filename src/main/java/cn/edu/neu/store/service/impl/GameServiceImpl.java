package cn.edu.neu.store.service.impl;

import cn.edu.neu.store.mapper.GameMapper;
import cn.edu.neu.store.mapper.UserMapper;
import cn.edu.neu.store.model.Games;
import cn.edu.neu.store.model.User;
import cn.edu.neu.store.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameMapper gameMapper;

    @Override
    public List<Games> getGameList(Games game) {
        return gameMapper.getGameList(game);
    }
    @Override
    public int addGame(Games game){
        try {
            gameMapper.addGame(game);
            return 0;
        }catch(Exception e) {
            e.printStackTrace();
            return 2;
        }
    }

    @Override
    public boolean deleteGame(Games game){
        try {
            gameMapper.deleteGame(game);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Games getGame(String gameid) {
        // TODO Auto-generated method stub
        return gameMapper.getGame(gameid);
    }
    //新页面用户修改后点击提交
    @Override
    public boolean updateGame(Games game) {
        try {
            gameMapper.updateGame(game);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public  List<Games> getEcharts(Games game){
        return  gameMapper.getEcharts(game);
    }

    public Map<String, String> getGamePla() {
        String Nintendo = gameMapper.countByPla("Nintendo");
        String Steam = gameMapper.countByPla("Steam");
        String PS5 = gameMapper.countByPla("PS5");
        String Xbox = gameMapper.countByPla("Xbox");
        String Epic = gameMapper.countByPla("Epic");
        String Switch = gameMapper.countByPla("Switch");

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("nintendo",Nintendo);
        resultMap.put("steam", Steam);
        resultMap.put("pS5", PS5);
        resultMap.put("xbox", Xbox);
        resultMap.put("epic", Epic);
        resultMap.put("switch", Switch);
        return resultMap;
    }



}
