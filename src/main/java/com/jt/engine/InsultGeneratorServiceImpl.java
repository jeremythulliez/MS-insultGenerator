package com.jt.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.jt.model.Insults;

@Service("insultGeneratorService")
public class InsultGeneratorServiceImpl implements InsultGeneratorService {

	@Override
	public String getRandomInsult() {
		Gson gson = new Gson();
		Insults insults = null;
		 try {
			insults = gson.fromJson(new InputStreamReader(new FileInputStream("bdd_insults.json"), "UTF-8"), Insults.class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException | UnsupportedEncodingException e) {
			return "no insult founded";
		}
		 Random rand = new Random();
		int rankName = rand.nextInt(insults.getNames().size() - 0) + 0;
		int rankAdj = rand.nextInt(insults.getAdjectives().size() - 0) + 0;
		 
		return insults.getNames().get(rankName).getValue().toString() + " " + insults.getAdjectives().get(rankAdj).getValue().toString() ;
	}

}
