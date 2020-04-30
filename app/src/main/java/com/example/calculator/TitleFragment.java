package com.example.calculator;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.calculator.databinding.FragmentTitleBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragment extends Fragment {


    public TitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final MyViewModel myViewModel;
        myViewModel = new ViewModelProvider(requireActivity(),new SavedStateViewModelFactory(requireActivity().getApplication(),requireActivity())).get(MyViewModel.class);
        FragmentTitleBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_title,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_titleFragment_to_questionFragment);
                myViewModel.getCurrentScore().setValue(0);
                myViewModel.generator();
            }
        });
        return binding.getRoot();
    }


}
