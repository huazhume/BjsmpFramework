package com.lenservice.bjmspqqmf.dataService;

import java.io.Serializable;
import java.util.List;


public class QFLunBoUtil {
	public List<Lunbo> result;
	public static class Lunbo implements Serializable{
		public String id;
		public String pic;
		public String describe;
		public String url;
		
	}
}
