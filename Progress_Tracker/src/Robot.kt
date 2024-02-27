import java.time.DayOfWeek
import java.time.LocalDateTime
import kotlin.random.Random


class Robot (val name:String){
	
	
	fun Alarm(alarmTime:LocalDateTime ,daysToSkip:List<DayOfWeek>){
		val today = LocalDateTime.now().dayOfWeek
		if(today !in daysToSkip && LocalDateTime.now().isAfter(alarmTime)){
			println("$name rings the alarm on time")
		}
		
	}
	
	fun makeCoffee(preferences: CoffeePreferences){
		println("$name makes coffee : ${preferences.coffeeType} , Sugar : ${preferences.sugarAmount}")
		
	}
	fun heatWater(preferences:BathPreferences){
		if(preferences.bathingDays.contains(LocalDateTime.now().dayOfWeek)){
			println("$name heats water to ${preferences.temperature}")
		}
	}
	fun Meal(pref:Mealpref){
		val breakfast= pref.breakfastOptions.random()
		val Lunch= pref.LunchOptions.random()
		println("$name cooks breakfast:$breakfast, Lunch:$Lunch")
	}
	fun Clothes(pref:String){
		println("$name iron clothes: $pref")
	}
	fun Bag(timetab:Map<DayOfWeek, List<String>>){
		val today = LocalDateTime.now().dayOfWeek
		val books = timetab[today] ?: emptyList()
		println("$name packs bag with books: $books")
		
	}
	
}	
	data class CoffeePreferences(val coffeeType: String, val sugarAmount: Int)
	data class BathPreferences(val bathingDays:List<DayOfWeek>, val temperature:Int)
	data class Mealpref(val breakfastOptions:List<String>,val LunchOptions:List<String>)
	


fun main(){
	val Rob = Robot("chiti")
	 
	val alarmTime= LocalDateTime.of(2024,2,5,7,0)
	val coffeePref = CoffeePreferences("blue", 8)
	val heat = BathPreferences(listOf(DayOfWeek.MONDAY,DayOfWeek.TUESDAY), 40)
	val meal = Mealpref(listOf("daal", "anda"), listOf("hjgfj", "hjcg"))
	val timetable = mapOf(
        DayOfWeek.MONDAY to listOf("Math", "Physics"),
        DayOfWeek.WEDNESDAY to listOf("Chemistry", "Biology"),
        DayOfWeek.FRIDAY to listOf("History", "Literature"))
	Rob.Alarm(alarmTime, listOf(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY))
	Rob.makeCoffee(coffeePref)
	Rob.heatWater(heat)
	Rob.Meal(meal)
	Rob.Clothes("Formal")
	Rob.Bag(timetable)
}

