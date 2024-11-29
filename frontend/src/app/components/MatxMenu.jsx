import { Fragment, Children } from "react"; // Importer Fragment et Children uniquement
import Menu from "@mui/material/Menu";
import { ThemeProvider, styled } from "@mui/material/styles";

import useSettings from "app/hooks/useSettings";
import backendAPI from "../../api";

import { useEffect, useState } from "react"; // Importer useEffect et useState une seule fois

// Composant principal pour l'appel API
const App = () => {
  const [data, setData] = useState(null);

  useEffect(() => {
    // Exemple d'appel GET
    backendAPI
        .get("/api/example")
        .then((response) => {
          setData(response.data);
          console.log("Données reçues :", response.data);
        })
        .catch((error) => {
          console.error("Erreur lors de l'appel API :", error);
        });
  }, []);

  return (
      <div>
        <h1>Appel API Backend</h1>
        <pre>{JSON.stringify(data, null, 2)}</pre>
      </div>
  );
};

// Export du composant App
export { App };

// STYLED COMPONENT
const MenuButton = styled("div")(({ theme }) => ({
  display: "inline-block",
  color: theme.palette.text.primary,
  "& div:hover": { backgroundColor: theme.palette.action.hover },
}));

// Composant MatxMenu
const MatxMenu = (props) => {
  const { settings } = useSettings();
  const [anchorEl, setAnchorEl] = useState(null);

  const children = Children.toArray(props.children);
  let { shouldCloseOnItemClick = true, horizontalPosition = "left" } = props;

  const handleClose = () => setAnchorEl(null);
  const handleClick = (event) => setAnchorEl(event.currentTarget);

  return (
      <Fragment>
        <MenuButton onClick={handleClick}>{props.menuButton}</MenuButton>
        <ThemeProvider theme={settings.themes[settings.activeTheme]}>
          <Menu
              elevation={8}
              open={!!anchorEl}
              anchorEl={anchorEl}
              onClose={handleClose}
              getContentAnchorEl={null}
              anchorOrigin={{ vertical: "bottom", horizontal: horizontalPosition }}
              transformOrigin={{ vertical: "top", horizontal: horizontalPosition }}
          >
            {children.map((child, index) => (
                <div
                    onClick={shouldCloseOnItemClick ? handleClose : () => {}}
                    key={index}
                >
                  {child}
                </div>
            ))}
          </Menu>
        </ThemeProvider>
      </Fragment>
  );
};

// Export du composant MatxMenu
export default MatxMenu;
