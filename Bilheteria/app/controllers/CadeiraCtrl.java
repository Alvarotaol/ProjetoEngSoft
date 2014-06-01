package controllers;

import models.Cadeira;
import models.Fileira;
import play.data.validation.Required;
import play.mvc.Controller;

public class CadeiraCtrl extends Controller {
    public static void criarCadeira(long id_estadio, long id_setor, long id_fileira, String nomeS, String nomeF, @Required String nomeC) {
        Cadeira c = new Cadeira(nomeC, id_fileira, 1);
        c.save();
            
        FileiraCtrl.fileiraExibir(id_estadio, id_setor, id_fileira, nomeS, nomeF);
    }
    
    public static void cadeiraApagar(long id_estadio, long id_setor, long id_fileira, long id, String nomeS, String nomeF) {
        Cadeira c = Cadeira.find("id", id).first();
        c.delete();
        FileiraCtrl.fileiraExibir(id_estadio, id_setor, id_fileira, nomeS, nomeF);
    }
    
    public static void cadeiraTornarDisponivel(long id_estadio, long id_setor, long id_fileira, long id, String nomeS, String nomeF) {
        Cadeira c = Cadeira.find("id", id).first();
        
        c.status = 1;
        c.save();
        
        FileiraCtrl.fileiraExibir(id_estadio, id_setor, id_fileira, nomeS, nomeF);
    }
    
    public static void cadeiraTornarIndisponivel(long id_estadio, long id_setor, long id_fileira, long id, String nomeS, String nomeF) {
        Cadeira c = Cadeira.find("id", id).first();
        
        c.status = 2;
        c.save();
        
        FileiraCtrl.fileiraExibir(id_estadio, id_setor, id_fileira, nomeS, nomeF);
    }    
}