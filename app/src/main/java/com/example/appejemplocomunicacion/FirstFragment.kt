package com.example.appejemplocomunicacion

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.appejemplocomunicacion.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {

    private val viewModelApp: ViewModelApp by activityViewModels()

    private lateinit var binding: FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFirstBinding.bind(view)

        setupUI()

        notificar()
    }

    private fun setupUI(){

        binding.textFirstFragment.text = "hola mufsadadadadadadadadadadadadadadadadadadadadadchachos!"
        binding.btnNextScreen.setOnClickListener {

            viewModelApp.navigation()

        }
    }

    private fun notificar(){
        binding.btnSendNotification.setOnClickListener {
            showNofitication()
        }
    }

    private companion object{
        const val CHANNEL_ID = "1"
    }

    private fun showNofitication() {

        createChannel()

        val intent = Intent(requireContext(), MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        val pendingIntent = PendingIntent.getActivity(requireContext(),0,intent,0)

        val notication = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_delete)
            .setContentTitle("Instagram123231")
            .setContentText("Maria Marta comenzo 231123a seguirte.")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("2132131231231212333333333333333333333333333333333333333333333333333333333333333!"))
            .setContentIntent(pendingIntent)
            .build()

        NotificationManagerCompat.from(requireContext()).notify(1,notication)
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ){
            val channel = NotificationChannel(
                CHANNEL_ID,
                "galiciaNotification",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            val notificationManager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

}