package com.esense.projekat_fpisv2.service;

import com.esense.projekat_fpisv2.dto.InsertObject;
import com.esense.projekat_fpisv2.dto.StavkaFaktureInsert;
import com.esense.projekat_fpisv2.entity.*;
import com.esense.projekat_fpisv2.repository.FakturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakturaService {

    private FakturaRepository fakturaRepository;
    private NacinPlacanjaService nacinPlacanjaService;
    private NacinIsporukeService nacinIsporukeService;
    private ZaposleniService zaposleniService;
    private ProizvodService proizvodService;

    public FakturaService(FakturaRepository fakturaRepository, NacinPlacanjaService nacinPlacanjaService, NacinIsporukeService nacinIsporukeService, ZaposleniService zaposleniService, ProizvodService proizvodService) {
        this.fakturaRepository = fakturaRepository;
        this.nacinPlacanjaService = nacinPlacanjaService;
        this.nacinIsporukeService = nacinIsporukeService;
        this.zaposleniService = zaposleniService;
        this.proizvodService = proizvodService;
    }

    @Transactional
    public List<Faktura> getAll(){ return fakturaRepository.findAll(); }

    @Transactional
    public List<Faktura> findAllByValuta(String valuta){ return fakturaRepository.findAllByValuta(valuta); }

    @Transactional
    public Faktura findById(Long id){
        Optional<Faktura> optionalFaktura = fakturaRepository.findById(id);
        if(optionalFaktura.isPresent()){
            return optionalFaktura.get();
        }else{
            return null;
        }
    }

    @Transactional
    public String deleteById(Long id){
        fakturaRepository.deleteById(id);
        return "Faktura je uspesno obrisana.";
    }

    @Transactional
    public Faktura save(InsertObject insertObject) throws Exception {

        NacinPlacanja np = nacinPlacanjaService.getOne(insertObject.getFakturaInsert().getNpID());

        NacinIsporuke ni = nacinIsporukeService.getOne(insertObject.getFakturaInsert().getNiID());

        Zaposleni zaposleni = zaposleniService.getById(insertObject.getFakturaInsert().getJmbg());

        AdresaIDembeddable id_adrese = new AdresaIDembeddable();
        id_adrese.setAdresa_ID(insertObject.getFakturaInsert().getAdresaID());
        id_adrese.setSifra_ulice(insertObject.getFakturaInsert().getSifraUlice());
        id_adrese.setPostanski_broj(insertObject.getFakturaInsert().getPostanskiBroj());
        Adresa adresa = new Adresa();
        adresa.setId(id_adrese);

        Faktura faktura = new Faktura(insertObject.getFakturaInsert().getDatumPrometa(),insertObject.getFakturaInsert().getValuta(),
                                        np,ni,zaposleni,adresa);

        fakturaRepository.save(faktura);

        long idFakture = faktura.getSifraFakture();
        System.out.println("ID nove fakture je: " + idFakture);

        List<StavkaFaktureInsert> stavkeFaktIns = insertObject.getStavkaFaktureInsert();

        for(int i = 0; i < stavkeFaktIns.size(); i++){

            Proizvod p = proizvodService.getOne(stavkeFaktIns.get(i).getSifraProizvoda());

            StavkaFakture sf = new StavkaFakture(stavkeFaktIns.get(i).getOpis(),stavkeFaktIns.get(i).getEan(),stavkeFaktIns.get(i).getKolicina(),p);
            sf.setId(new StavkaFaktureIDembeddable(stavkeFaktIns.get(i).getSifraStavke(),idFakture));

            System.out.println("ID stavke je: stavka: "+ sf.getId().getSifraStavke() + " faktura: "+ sf.getId().getSifraFakture());

            faktura.dodajStavkuFakture(sf);
        }

        return faktura;
    }

    // pokusaj za update
    @Transactional
    public Faktura update(InsertObject insertObject) throws Exception {

        NacinPlacanja np = nacinPlacanjaService.getOne(insertObject.getFakturaInsert().getNpID());

        NacinIsporuke ni = nacinIsporukeService.getOne(insertObject.getFakturaInsert().getNiID());

        Zaposleni zaposleni = zaposleniService.getById(insertObject.getFakturaInsert().getJmbg());

        AdresaIDembeddable id_adrese = new AdresaIDembeddable();
        id_adrese.setAdresa_ID(insertObject.getFakturaInsert().getAdresaID());
        id_adrese.setSifra_ulice(insertObject.getFakturaInsert().getSifraUlice());
        id_adrese.setPostanski_broj(insertObject.getFakturaInsert().getPostanskiBroj());
        Adresa adresa = new Adresa();
        adresa.setId(id_adrese);

        List<StavkaFaktureInsert> stavkeFaktIns = insertObject.getStavkaFaktureInsert();
        List<StavkaFakture> stavkeFakture = new ArrayList<>();

        for(int i = 0; i < stavkeFaktIns.size(); i++){

            Proizvod p = proizvodService.getOne(stavkeFaktIns.get(i).getSifraProizvoda());

            StavkaFakture sf = new StavkaFakture(stavkeFaktIns.get(i).getOpis(),stavkeFaktIns.get(i).getEan(),stavkeFaktIns.get(i).getKolicina(),p);
            sf.setId(new StavkaFaktureIDembeddable(stavkeFaktIns.get(i).getSifraStavke(),insertObject.getFakturaInsert().getSifraFakture()));

            stavkeFakture.add(sf);
        }

        Faktura faktura = new Faktura(insertObject.getFakturaInsert().getSifraFakture(),
                insertObject.getFakturaInsert().getDatumPrometa(),insertObject.getFakturaInsert().getValuta(),
                np,ni,zaposleni,adresa,stavkeFakture);

        fakturaRepository.save(faktura);

        System.out.println("Uspesno izmenjena faktura.");

        return faktura;
    }

}
