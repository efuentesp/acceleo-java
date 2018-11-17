package com.softtek.acceleo.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.aspectj.weaver.patterns.ParserException;


public class FormatterDate {
	private static final Logger logger = Logger.getLogger(FormatterDate.class);
	
	/**
	 * Si se llegara a necesitar algun otro formato, ponerlo en este arreglo.
	 */
	private static final String[] formats = {"yyyy-MM-dd", "yyyy/MM/dd", "MM/dd/yyyy"};
	
	/**
	 * Convierte una fecha a cadena.
	 * @param date decha a convertir a cadena.
	 * @param format formato que debe tener la cadena.
	 * @return 
	 * 		String.
	 */
	public static String format(Date date, String formatDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
		
		try {
			return sdf.format(date);
		}catch(NullPointerException e) {
			return "";
		}catch(Exception e) {
			return "";
		}
	}
	
	/**
	 * Convierte una cadena a un objeto de tipo java.util.Date
	 * @param strDate cadena a convertir a Date. 
	 * @param formatDate formato que tiene la cadena strDate.
	 * @return 
	 * 		Date
	 */
	public static Date parse(String strDate, String formatDate) {
		SimpleDateFormat sdf = null;
		Date date = null;
		
		try {
			sdf = new SimpleDateFormat(formatDate);
			
			date = sdf.parse(strDate);
		}catch(ParseException e) {
			for( String format : formats ) {
				sdf = new SimpleDateFormat(format);
				
				try {
					date = sdf.parse(strDate);
					break;
				}catch(ParseException pe) {
					logger.error("Error al darle formato a la fecha <" + strDate + "> con el formato <" + format + ">", pe);
				}
			}
		}catch(NullPointerException e ) {
			logger.error(e);
		}
		
		return date;
	}
	
}
