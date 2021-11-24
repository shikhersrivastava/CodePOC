package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@ComponentScan({"com.example.demo"})
public class UserService {

   @Autowired
   private  UserRepo repos;



 // @Override
  public String post(UserDto userDto)
    {
        try {
            User user = new User();
              user.setAddress("Delhi");
              user.setDOB("12/12/12");
            user.setName("Name1");
            user.setPinCode("201204");
            user.setSurName("SSSS");

            System.out.println("user={}" + user.getName());
           repos.save(user);
        }
        catch (NullPointerException ex)
        {
            ex.printStackTrace();
        }
        return "Success";

    }

    //@Override
    public String update(UserDto userDto)
    {

        Optional<User> user=repos.findById(userDto.getId());
        if(user.isEmpty())
        {
            System.out.println("data not found");
            return "Data not found";
        }
        user.get().setSurName(userDto.getSurName());
        user.get().setPinCode(userDto.getPincode());
        user.get().setAddress(userDto.getAddress());
        user.get().setDOB(userDto.getDOB());
        user.get().setName(userDto.getName());
        repos.save(user.get());
   return "Success";
    }

    //@Override
    public List<User> findByKey(String key)
    {
        System.out.println("the key are={}"+key);
        List<User> user=repos.findAll();
        user=user.stream().filter(c->c.getName().equalsIgnoreCase(key)).collect(Collectors.toList());
        System.out.println("Result={}"+user);
        if(user!=null)
        {
            return user;
        }
        return user;

    }

  //  @Override
    public String deleteById(Long id)
    {
        Optional<User> user=repos.findById(id);
        if(!user.isEmpty())
        {
            repos.deleteById(id);
            return "User Deleted Succes fully";
        }
        return "User not found";

    }
}
