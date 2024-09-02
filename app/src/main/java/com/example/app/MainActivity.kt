package com.example.app
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.sanarcare.sanarkit.SanarKit
import com.sanarcare.sanarkit.UserInfo

class MainActivity : ComponentActivity() {

    val userInfo = UserInfo(
        firstName = "Abdul",
        lastName = "Aziz",
        dob = "1994-08-13",
        gender = "M",
        nationality = "Saudi Arabia",
        documentId = "2469433220",
        mid = "MG2",
        documentType = 1,
        phoneCode = "91",
        phoneNo = "81794771111",
        maritalStatus = "0"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // initializing Sanar Connect
        val sanarKit = SanarKit(this)

        // Connect to Sanar Services
        val srConnect = findViewById<Button>(R.id.sr_connect_button)
        srConnect.setOnClickListener {
            sanarKit.connect(
                userInfo = userInfo,
                authToken = "<auth-token>",
                bundleId = "com.example.demo"
            )
        }

        // Button to initiate Sanar Booking flow
        val srBooking = findViewById<Button>(R.id.sr_booking)
        srBooking.setOnClickListener {
            // Sanar Booking flow method
            sanarKit.gotoBookingView()
        }

        // Button to initiate Sanar Appointment flow
        val srAppointments = findViewById<Button>(R.id.sr_appointment)
        srAppointments.setOnClickListener {
            // Sanar Appointment list flow method
            sanarKit.gotoAppointmentListView()
        }

        // Button to disconnect from Sanar Services
        val srDisconnect = findViewById<Button>(R.id.sr_disconnect_button)
        srDisconnect.setOnClickListener {
            // Disconnect from Sanar services
            sanarKit.disconnect()
        }
    }
}
