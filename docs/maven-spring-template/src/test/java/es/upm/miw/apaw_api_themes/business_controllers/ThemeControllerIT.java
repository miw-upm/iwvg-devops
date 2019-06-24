package es.upm.miw.apaw_api_themes.business_controllers;

import es.upm.miw.apaw_api_themes.TestConfig;
import es.upm.miw.apaw_api_themes.daos.ThemeDao;
import es.upm.miw.apaw_api_themes.daos.UserDao;
import es.upm.miw.apaw_api_themes.documents.Address;
import es.upm.miw.apaw_api_themes.documents.Theme;
import es.upm.miw.apaw_api_themes.documents.User;
import es.upm.miw.apaw_api_themes.dtos.ThemeCreationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class ThemeControllerIT {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ThemeBusinessController themeBusinessController;

    @Autowired
    private ThemeDao themedao;

    @Test
    void testCreateTheme() {
        User user = new User("nick1", "email", new Address("country", null, null));
        this.userDao.save(user);
        String themeId = this.themeBusinessController.create(new ThemeCreationDto("theme-1", user.getId())).getId();
        Theme theme = this.themedao.findById(themeId).get();
        assertEquals("theme-1", theme.getReference());
        assertEquals("nick1", theme.getUser().getNick());
        assertNotNull(theme.getDate());
    }
}
