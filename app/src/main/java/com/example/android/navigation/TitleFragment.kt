package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //remember that the <FragmentTitleBinding> is a class auto generated for us
        //by the <layout> tag in the xml files, so we can use the binding object
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container,false)

        binding.playButton.setOnClickListener{ view: View->
            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }
        //inicia el menu i guess?
        setHasOptionsMenu(true)



        return binding.root
    }

    //this method creates the menu of the app bar
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    //and this method method to take the appropriate action when the menu item is tapped.
    // In this case, the action is to navigate to the Fragment that has the same id as the
    // selected menu item.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}