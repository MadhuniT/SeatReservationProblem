import java.util.Scanner;
import scala.util.control.Breaks._

object Seat{

	def display_seats(seats:Array[Array[Int]],a:Int,b:Int):Unit={
		
		print("\t")
		
		for(y <- 0 to b-1 ){
            		print("S "+ (y+1) + "\t")
        	}
		println("")
		for( x <- 0 to a-1 ){
      			print("Dest "+ (x+1) + "\t")
        		for(y <- 0 to b-1 ){
            			print(seats(x)(y)+"\t")
        		}
			println("")
    		}
		
	}
	
	def main (args:Array [String]):Unit={
		
		var no_of_destination=4
		var no_of_seats=50

		val seat_table=Array.ofDim[Int](no_of_destination,no_of_seats)
		
		var i=0
		var continue='Y'
		var dest=0
		var seat=0		

		println(" ")
		println("Available seats shows - 0 ")
		println("Unavailable seats shows - 1 ")
		println("Continue(Y/N) Y-Yes N-No")
		println("")
		println("----------------------------------------------")

		while(i< no_of_destination){
			
			if(i==0){
				println("Start journey - Booking seats")
				println("-----------------------------")
			}
			
			else{
				println("Destination - " + (i) )
				println("-----------------------------")
				
				for(y <- 0 to no_of_seats-1 ){
            				seat_table(i-1)(y)=0
        			}
			}
			
			

			display_seats(seat_table,no_of_destination,no_of_seats)
			continue='Y'
			while(continue=='Y'){

				print("Enter destination : ")
				dest=scala.io.StdIn.readInt()
				print("Enter seat no : ")
				seat=scala.io.StdIn.readInt()
				
				if(dest>no_of_destination-1 && seat>no_of_seats-1){
					println("Invalid Inputs")
				}
				
				else{
				
					var j=0
					var c=0

					for(j <- 0 to no_of_destination-1 ){
            					if(seat_table(j)(seat-1)==0)
							c=c+1		 
        				}

					if(c==no_of_destination){
						seat_table(dest-1)(seat-1)=1
						println("Booked successfully")
					}
					else{
				
						println("Booking is not available")	
					}

					print("Continue(Y/N) : ")
					continue=scala.io.StdIn.readChar()
				}
			}
			
			println("")
			display_seats(seat_table,no_of_destination,no_of_seats)
			println("")
			
			i=i+1
		}
		

	}

}