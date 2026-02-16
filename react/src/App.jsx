import { BrowserRouter, Routes, Route } from 'react-router-dom';
import HomeView from './views/HomeView/HomeView';
import LoginView from './views/LoginView/LoginView';
import LogoutView from './views/LogoutView';
import RegisterView from './views/RegisterView/RegisterView';
import UserProfileView from './views/UserProfileView/UserProfileView';
import MainNav from './components/MainNav/MainNav';
import ProtectedRoute from './components/ProtectedRoute';
import NFLView from './views/NFLView/NFLView';
import PlayerView from './views/PlayerView/PlayerView';
import PlayerInfoView from './views/PlayerInfoView/PlayerInfoView';

export default function App() {

  return (
    <BrowserRouter>
      <div id="app">
          <MainNav />
          <main id="main-content">
            <Routes>
              <Route path="/" element={<HomeView />} />
              <Route path="/login" element={<LoginView />} />
              <Route path="/logout" element={<LogoutView />} />
              <Route path="/register" element={<RegisterView />} />
              <Route path="/nfl" element={<NFLView />} />
              <Route path='/nfl/:team' element={<PlayerView />} />
              <Route path='/nfl/:team/:player' element={<PlayerInfoView />} />
              <Route
                path="/userProfile"
                element={
                  <ProtectedRoute>
                    <UserProfileView />
                  </ProtectedRoute>
                }
              />
            </Routes>
          </main>
      </div>
    </BrowserRouter>
  );
}
