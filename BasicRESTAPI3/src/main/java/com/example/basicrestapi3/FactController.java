package com.example.basicrestapi3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class FactController {

    @Autowired
    private FactDao factDao;

    @RequestMapping(value="/addFact", method= RequestMethod.POST)
    public Fact addFact(@RequestBody Fact newFact) throws IOException{
        factDao.create(newFact);
        return newFact;
    }

    @RequestMapping(value="/getFact/{id}", method= RequestMethod.GET)
    public Fact getFact(@PathVariable("id") int id) throws IOException {
        return factDao.getById(id);
    }

    @RequestMapping(value="/updateFact", method= RequestMethod.PUT)
    public Fact updateFact(@RequestBody Fact newFact) throws IOException {
        factDao.update(newFact);
        return newFact;
    }

    @RequestMapping(value="/deleteFact/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<String> deleteFact(@PathVariable("id") int id) throws IOException {
        Fact fact = factDao.getById(id);
        factDao.delete(fact);
        return ResponseEntity.ok("Fun Fact deleted.");
    }

    @RequestMapping(value="/getLatestFact", method= RequestMethod.GET)
    public List<Fact> getLatestFact() throws IOException {
        return factDao.getLatest();
    }

}
