package com.partos.musicclicker.fragments.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.partos.musicclicker.R
import com.partos.musicclicker.logic.game.GameLimitedLogic

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "gameType"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameLimitedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameLimitedFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var gameType: Int? = null
    private var param2: String? = null
    private lateinit var rootView: View
    private lateinit var logicHolder: GameLimitedLogic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            gameType = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_game_limited, container, false)
        logicHolder = GameLimitedLogic(rootView, gameType as Int)
        logicHolder.initFragment()
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GameLimitedFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(gameType: Int) =
            GameLimitedFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, gameType)
                }
            }
    }
}