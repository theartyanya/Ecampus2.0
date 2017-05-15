package com.example.thear.ecampus20.ui.fragment.main.discipline_choice;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.thear.ecampus20.R;
import com.example.thear.ecampus20.model.Course;
import com.example.thear.ecampus20.model.Semestr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleks on 15.05.2017.
 */

public class SemestrFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Course> courseList = new ArrayList<>();
    private Context context;

    public SemestrFragmentPagerAdapter(FragmentManager fm, List<Semestr> semestrs, Context context) {
        super(fm);
        this.context = context;
        courseList = generateCoursesList(semestrs);
    }

    @Override
    public Fragment getItem(int position) {
        return DisciplineSemestrFragment.newInstance(courseList.get(position));
    }

    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.valueOf(position + 1).concat(" ").concat(context.getString(R.string.course));
    }

    private List<Course> generateCoursesList(List<Semestr> semestrs) {
        List<Course> courses = new ArrayList<>();
        Course course = null;
        for (int i = 0; i < semestrs.size(); i++) {
            if (i % 2 == 0) {
                course = new Course();
                course.getSemestrs().add(semestrs.get(i));
            } else {
                course.getSemestrs().add(semestrs.get(i));
                courses.add(course);
            }
        }
        Log.d("mytag", courses.size() + "");
        return courses;
    }
}
