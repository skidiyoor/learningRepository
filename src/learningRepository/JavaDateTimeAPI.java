package learningRepository;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class JavaDateTimeAPI {
	
	public static void main(String[] args)
	{
		//1.Create
		
			// DATE
				LocalDate date=LocalDate.of(2019, 06, 20); 
				LocalDate dateNew=LocalDate.of(2019,Month.JUNE,22);
				
			//TIME
				LocalTime time=LocalTime.of(21, 20);
				LocalTime timeWithSeconds=LocalTime.of(21, 20,55);
				LocalTime timeWithNanoSeconds=LocalTime.of(21, 20,55,99);
				
			//DATETIME
				LocalDateTime dateTime=LocalDateTime.of(date, time);
				LocalDateTime dateTimeNew=LocalDateTime.of(2019, 06, 21, 12, 20); //all combination of both date and time objects
				
			//INSTANT
				Instant instant=Instant.ofEpochSecond(20000); //specify seconds from EPOCH
				Instant instantSecondsWithNano=Instant.ofEpochSecond(20000, 9999); //specify nanosec precision of seconds
				Instant instantWithMilli=Instant.ofEpochMilli(500000); //milliseconds
				
			//PERIOD
				Period period=Period.between(date, dateNew); //startDate include and end date exclude
				Period periodNew=Period.of(2, 20, 30); //year,Month,days    output--P2Y20M30D  
				                     //.ofYears(int years)
				                     //.ofMonths(int months)
									 //.ofWeeks(int weeks)
									 //.ofDays(int days)
		   //DURATION
				Duration duration=Duration.between(timeWithNanoSeconds, time); //start time include and end time exclude
				Duration durationNew=Duration.of(320,ChronoUnit.SECONDS);// we also have DAYS,HALF_DAYS,HOURS,MINUTES etc as chronounit enum values
				                           //.ofDays(days)
										   //.ofHours(hr);
										   //.ofMinutes(min);
										   //.ofSeconds(sec);
										   //.ofMillis(milli);
										   //.ofNanos(nanos); 
		
	//2.GET methods
			//DATE
					int year=date.getYear();
					int month=date.getMonthValue();
					Month monthString=date.getMonth();
					int day=date.getDayOfMonth();
					int dayOfYear=date.getDayOfYear();
					DayOfWeek dayOfWeek=date.getDayOfWeek();
			//TIME
					int hour=time.getHour();
					int min=time.getMinute();
					int sec=time.getSecond();
					int nano=time.getNano();
		   //DATETIME
					//both mahods of date and time
					
					//datetime can be created this way too. we can specify arguments in different ways
					LocalDateTime dt=time.atDate(date);
					LocalDateTime dtnew=date.atTime(time);
					
		   //INSTANT
					long seconds=instant.getEpochSecond();
					int nanoValue=instant.getNano();
					int ins=instant.get(ChronoField.MILLI_OF_SECOND); //there are different chronofield values
		   //PERIOD
					int p_years=period.getYears();
					int p_months=period.getMonths();
					int p_days=period.getDays();
					long p=period.get(ChronoUnit.DAYS);
		  //DURATION
					long d_seconds=duration.getSeconds();
					int d_nano=duration.getNano();
					long d=duration.get(ChronoUnit.SECONDS);
					
	//3. Conditional checks
					//For DATE,TIME,DATETIME,INSANT
					   //x.isAfter(y)
					   //x.isBefore(y);
					   //x.equals(y);
					
	//4.Adding and subtracting
		//DATE
					LocalDate dateAdd=date.plusYears(10);
					                     //.plusMonths(10);
										 //.plusDays();
										 //.plusWeeks();
										 //.plus(5,chronoUnit.YEARS)
					                     //.plus(Period.of(12, 2, 4));
					LocalDate dateSub=date.minusYears(10);
                    					//.minusMonths(10);
										//.minusDays();
					 					//.minusWeeks();
					 					//.minus(5,chronoUnit.YEARS)
					                    //.minus(Period.of(12, 2, 4));
		//TIME
					LocalTime timeAdd=time.plusHours(20);
										//.plusMinutes(10);
					 					//.plusSeconds();
					 					//.plusNanos();
					 					//.plus(5,chronoUnit.HOURS)
					                    //.plus(Duration.ofHours(20));
					LocalTime timeSub=time.plusHours(20);
										//.minusMinutes(10);
 										//.minusSeconds();
 										//.minusNanos();
 										//.minus(5,chronoUnit.HOURS)
										//.minus(Duration.ofHours(20));
		//DATETIME
					//all the methods in date and time
		//INSTANT
					Instant instantAdd=instant.plusSeconds(200);
					                        //.plusNanos(5622);
					                        //.plusMillis(25698);
					                        //.plus(256,chronoUnit.SECONDS)
					                        //.plus(Duration.ofDays(10));
					Instant instantSub=instant.minusSeconds(200);
                    						//.minusNanos(5622);
                    						//.minusMillis(25698);
					                        //.minus(256,chronoUnit.SECONDS)
											//.minus(Duration.ofDays(10));
		//PERIOD
					Period periodAdd=period.plusYears(2);
					                    //.plusMonths(3);
					                    //.plusDays(20);
					                    //.plus(anotherPeriod);
					
					Period periodSub=period.minusYears(2);
                    					 //.minusMonths(3);
                    					 //.minusDays(20);
                    					 //.minus(anotherPeriod);
					
		//DURATION
					Duration durationAdd = duration.plusDays(4);
												 //.plusHours(3);
											   	 //.plusMinutes(3);
												 //.plusSeconds(3);
												 //.plusMillis(3);
												 //.plusNanos(3);
												 //.plus(twoSeconds);
												 //.plus(1, ChronoUnit.DAYS); 

					// Subtracting
					Duration durationSub = duration.minusDays(4);
												 //.minusHours(3);
					                             //.minusMinutes(3);
					                             //.minusSeconds(3);
					                             //.minusMillis(3);
					                             //.minusNanos(3);
					                             //.minus(twoSeconds);
					                             //.minus(1, ChronoUnit.DAYS);
					
//5.Creating another instance from existing one
				
		//DATE
					LocalDate dateWith=date.withYear(2018);
					                   //date.withMonth(02);
					                   //date.withDayOfMonth(20);
					                   //date.withDayOfYear(256);
					                   //date.with(ChronoField.DAY_OF_MONTH, 12);
					                   //date.withYear(2014).withMonth(12);
		//TIME
					LocalTime timeWith=time.withHour(12);
					                   //time.withMinute(50);
					                   //time.withSecond(55);
					                   //time.withNano(256);
					                   //time.with(ChronoField.NANO_OF_SECOND, 2589);
	   //DATETIME
					//both sets and chain of both
	   //INSTANT
					Instant instantWith=instant.with(ChronoField.NANO_OF_SECOND, 2561);
	   //PERIOD
					Period periodWith=period.withYears(2018);
	                                 //period.withMonths(02);
					                 //period.withDays(25);
	                                 //period.with(ChronoField.DAY_OF_MONTH, 12);
	                                 //period.withYears(2014).withDays(12);
	  //DURATION
					Duration durationWith=duration.withSeconds(25);
					                      //duration.withNanos(256);
				
					 
					
					

					
					
					
					
					
				
			
			                     
			                             
			
	}

}
