package cn.edu.neu.store.controller;

import cn.edu.neu.store.core.Constants;
import cn.edu.neu.store.core.util.FileUtil;
import cn.edu.neu.store.model.Games;

import cn.edu.neu.store.model.User;
import com.alibaba.fastjson.JSON;
import cn.edu.neu.store.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/getGameList")
    public String getGameList(Games game, Map<String, List<Games>> m) {
        System.out.println(game);
        List<Games> gameList = gameService.getGameList(game);
        m.put("gameList", gameList);
        System.out.println("m:" + m);
        return "/games/getGameList";
    }

    @RequestMapping("/")
    public String getGame(Games game, Map<String, List<Games>> m) {
        System.out.println(game);
        List<Games> gameList = gameService.getGameList(game);
        m.put("gameList", gameList);
        System.out.println("m:" + m);
        return "/index";
    }
    @RequestMapping("/toAdd")
    public String getAdd(){
        return "/games/addGame";
    }
    @RequestMapping("/addGame")
    public String addGame(Games game, Model model, Map<String, List<Games>> m, HttpServletRequest request){
        MultipartFile file=game.getFile();
        System.out.println("size:========================="+file.getSize());
        File dest=null;
        String filePath=null;
        if(!file.isEmpty()) {//上传文件不为空
            dest= FileUtil.uploadFile(file, request);
            if(dest==null) {
                model.addAttribute("result", "no");
                model.addAttribute("msg", "照片文件上传失败");
                return "/user/result";
            }
            System.out.println("dest.getPath():===================="+dest.getPath());
            System.out.println("dest.getPath().substring:======="+dest.getPath().substring(dest.getPath().lastIndexOf("\\")));
            filePath= Constants.UPLOAD_PATH+dest.getPath().substring(dest.getPath().lastIndexOf("\\")+1);
            System.out.println("filePath::::::"+filePath);
            game.setFilePath(filePath);
        }
        gameService.addGame(game);
        List<Games> gameList = gameService.getGameList(game);
        m.put("gameList",gameList);
        return "redirect:/games/getGameList";
    }

    @RequestMapping("/deleteGame")
    public String deleteGame(Games game){
        System.out.println("deleteGame========================"+game);
        boolean f = gameService.deleteGame(game);
        Map<String,String> m=new HashMap<String,String>();
        if(f){
            m.put("result", "yes");
            m.put("msg", "恭喜您，删除成功");
            return "forward:/games/getGameList";
        }else {
            m.put("result", "no");
            m.put("msg", "对不起，删除失败");
            return "redirect:/games/getGameList";
        }
    }

    @RequestMapping("/getGames")
    public String getGame(String gameid, Map<String, Games> m){
        System.out.println("getUser1111:"+gameid);
        Games game=gameService.getGame(gameid);
        m.put("game", game);
        System.out.println("game:"+game);
        return "/games/updategame";
    }
    //新页面用户修改后点击提交
    @RequestMapping("/updateGame")
    public String updateGame(Games game, Model model, Map<String, List<Games>> m, HttpServletRequest request){
        MultipartFile file=game.getFile();
        System.out.println("size:========================="+file.getSize());
        File dest=null;
        String filePath=null;
        if(!file.isEmpty()) {//上传文件不为空
            dest= FileUtil.uploadFile(file, request);
            if(dest==null) {
                model.addAttribute("result", "no");
                model.addAttribute("msg", "照片文件上传失败");
                return "/user/result";
            }
            System.out.println("dest.getPath():===================="+dest.getPath());
            System.out.println("dest.getPath().substring:======="+dest.getPath().substring(dest.getPath().lastIndexOf("\\")));
            filePath= Constants.UPLOAD_PATH+dest.getPath().substring(dest.getPath().lastIndexOf("\\")+1);
            System.out.println("filePath::::::"+filePath);
            game.setFilePath(filePath);
        }
        gameService.updateGame(game);
        System.out.println("update:"+m);
        return "redirect:/games/getGameList";
    }

    @RequestMapping(value = "/getEcharts")
    public String getEcharts(Games game, Map<String, List<Games>> m,Model model){
        System.out.println(game);
        List<Games> gameList = gameService.getGameList(game);
        m.put("gameList", gameList);
        model.addAttribute("name",gameList);
        model.addAttribute("price",gameList);
        System.out.println("m:" + m);
        return "/games/gameecharts";
    }

    @GetMapping("/platform")
    @ResponseBody
    public Map<String, String> getGamePla() {
        return gameService.getGamePla();
    }

}
