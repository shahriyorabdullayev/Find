package com.shza.cleanarch2.presentation.fragment

import android.app.Dialog
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.TextAppearanceSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shza.cleanarch2.R
import com.shza.cleanarch2.databinding.FragmentWelcomeBinding
import com.shza.cleanarch2.presentation.activity.MainActivity
import kotlin.random.Random


class WelcomeFragment : Fragment() {


    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding
    get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setSpannableTextGameRules()
        binding.buttonUnderstand.setOnClickListener {
            launchChooseLevelFragment()
        }
        binding.ivMore.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog)
        dialog.setCancelable(true)
        val llTelegramLink = dialog.findViewById<LinearLayout>(R.id.ll_telegram)
        val llAbout = dialog.findViewById<LinearLayout>(R.id.ll_about)

        llAbout.setOnClickListener {
            notification()
        }

        llTelegramLink.setOnClickListener {
            callTelegram()
        }

        dialog.show()
    }

    private fun callTelegram() {
        val url = "https://t.me//shakhriyor13"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        requireActivity().startActivity(intent)
    }

    private fun notification() {

        Toast.makeText(requireContext(), "Notification", Toast.LENGTH_SHORT).show()
        val icon1 = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)

        val bigText = NotificationCompat.BigTextStyle()
        bigText.bigText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
        bigText.setBigContentTitle("Big text notification")
        bigText.setSummaryText("By Shahriyor")

        //buildNotification
        val builder = NotificationCompat.Builder(requireContext())
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Big Text Notification")
            .setContentText("Bu katta notification")
            .setLargeIcon(icon1)
            .setStyle(bigText)


        val notificationManager = requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(Random.nextInt(), builder.build())
    }


    private fun setSpannableTextGameRules() {
        val spannableString = SpannableString(getString(R.string.game_rules))
        spannableString.setSpan(TextAppearanceSpan(context, R.style.myFontSize),
            0,
            18,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.tvGameRules.text = spannableString
    }

    private fun launchChooseLevelFragment() {
        findNavController().navigate(R.id.action_welcomeFragment_to_chooseLevelFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}