package taxi.service.impl;

import taxi.dao.DriverDao;
import taxi.exception.AuthenticationException;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Driver;
import taxi.service.AuthenticationService;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        Optional<Driver> user = driverDao.findByLogin(login);

        if (user.isEmpty()) {
            throw new AuthenticationException("Can't find user with login " + login);
        }

        Driver driver = user.get();
        if (driver.getPassword().equals(password)) {
            return driver;
        }
        throw new AuthenticationException("Password is incorrect, for user with login " + login);
    }
}
