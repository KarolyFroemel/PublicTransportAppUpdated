import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Keycloak from "keycloak-js";
import { httpClient } from './HttpClient';

let initOptions = {
    url: 'http://localhost:8180',
    realm: 'PublicTransportApp',
    clientId: 'public_transport_frontend',
}

let keycloakClient = new Keycloak(initOptions);

keycloakClient.init({
    onLoad: 'login-required', // Supported values: 'check-sso' , 'login-required'
    checkLoginIframe: true,
    pkceMethod: 'S256'
}).then((auth) => {
    if (!auth) {
        window.location.reload();
    } else {
        /* Remove below logs if you are using this on production */
        console.info("Authenticated");
        console.log('auth', auth)
        console.log('Keycloak', keycloakClient)
        console.log('Access Token', keycloakClient.token)

        /* http client will use this header in every request it sends */
        httpClient.defaults.headers.common['Authorization'] = `Bearer ${keycloakClient.token}`;

        keycloakClient.onTokenExpired = () => {
            console.log('token expired')
        }
    }
}, () => {
    /* Notify the user if necessary */
    console.error("Authentication Failed");
});

function App() {
  const [count, setCount] = useState(0);

    const callBackend = () => {
        httpClient.get('http://localhost:8081/hello/greeting?name=dagi').then(response => {
            console.log("Sikeres uzenet:");
            console.log("valasz:" + response.data);
        }).catch(error => {
            console.log("Sikertelen uzenet:");
            console.log(error);
        })

    };

    console.log("Is user authenticated?" + keycloakClient.authenticated)

  return (
      <>
          <div>
              <a href="https://vitejs.dev" target="_blank">
                  <img src={viteLogo} className="logo" alt="Vite logo"/>
              </a>
              <a href="https://react.dev" target="_blank">
                  <img src={reactLogo} className="logo react" alt="React logo"/>
              </a>
          </div>
          <h1>Vite + React</h1>
          <div className="card">
              <button onClick={() => setCount((count) => count + 1)}>
                  count is {count}
              </button>
              <p>
                  Edit <code>src/App.jsx</code> and save to test HMR
              </p>
          </div>
          <p className="read-the-docs">
              Click on the Vite and React logos to learn more
          </p>
          <button onClick={callBackend}>DAGI</button>
      </>
  )
}

export default App
