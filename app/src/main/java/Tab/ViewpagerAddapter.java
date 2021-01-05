package Tab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewpagerAddapter extends FragmentPagerAdapter {
    public ViewpagerAddapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Homefrg homefrg=new Homefrg();
                return homefrg;
            case 1:
                Tavfrg tavfrg=new Tavfrg();
                return tavfrg;
            case 2:
                Moviefrg moviefrg=new Moviefrg();
                return  moviefrg;
            case 3:
                Kidsfrg kidsfrg=new Kidsfrg();
                return kidsfrg;
            default:return  null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       switch (position){
           case 0:
               return "Home";
           case 1:
               return "Tvshows";
           case 2:return "Movies";
           case 3:return "Kids";
           default:return null;
       }
    }
}
