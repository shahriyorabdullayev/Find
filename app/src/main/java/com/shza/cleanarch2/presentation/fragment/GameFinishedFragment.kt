package com.shza.cleanarch2.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shza.cleanarch2.R
import com.shza.cleanarch2.databinding.FragmentGameFinishedBinding
import com.shza.cleanarch2.domain.entity.GameResult
import java.lang.RuntimeException


class GameFinishedFragment : Fragment() {

    //private lateinit var gameResult: GameResult
    private val args by navArgs<GameFinishedFragmentArgs>()

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //parseArgs()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        bindViews()

    }

    private fun bindViews() {
        binding.gameResult = args.gameResult
        with(binding) {
            emojiResult.setImageResource(getSmileResId())
//            tvRequiredAnswers.text = String.format(
//                getString(R.string.required_score),
//                args.gameResult.gameSettings.minCountOfRightAnswers
//            )
//            tvScoreAnswers.text = String.format(
//                getString(R.string.score_answers),
//                args.gameResult.countOfRightAnswers
//            )
//            tvRequiredPercentage.text = String.format(
//                getString(R.string.required_percentage),
//                args.gameResult.gameSettings.minPercentOfRightAnswers
//            )
//            tvScorePercentage.text = String.format(
//                getString(R.string.score_percentage),
//                getPercentOfRightAnswers()
//            )
            val gameResultText = if (args.gameResult.winner) {
                getString(R.string.you_win)
            } else {
                getString(R.string.game_over)
            }
            tvResult.text = gameResultText
        }
    }

    private fun getPercentOfRightAnswers() = with(args.gameResult) {
        if (countOfQuestions == 0) {
            0
        } else {
            ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
        }
    }

    private fun getSmileResId(): Int {
        return if (args.gameResult.winner) {
            R.drawable.ic_smile
        } else {
            R.drawable.ic_sad
        }

    }

    private fun setupClickListeners() {

        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }

//    private fun parseArgs() {
//        requireArguments().getParcelable<GameResult>(KEY_GAME_RESULT)?.let {
//            gameResult = it
//        }
//    }

    private fun retryGame() {
        findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val KEY_GAME_RESULT = "game_result"

        fun newInstance(gameResult: GameResult): GameFinishedFragment {
            return GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_GAME_RESULT, gameResult)
                }
            }
        }
    }
}