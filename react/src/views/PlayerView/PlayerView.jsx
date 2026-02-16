import { useParams, Link } from "react-router-dom";
import AuthService from "../../services/AuthService";
import { useState, useEffect } from 'react';
import styles from './PlayerView.module.css';

export default function PlayerView() {
    const { team } = useParams();
    const [players, setPlayers] = useState(null);

    function getPlayersByTeam() {
        AuthService.getPlayersByTeam(team)
            .then((response) => {
                setPlayers(response.data);
            })
    }

    useEffect(() => {
        getPlayersByTeam();
    }, []);

    return (
        <div className={styles.playerGrid}>
            {players &&
                players.map((playerItem) => (
                    <div key={playerItem.PlayerId}>
                        <Link to={`${playerItem.Name}`} state={{playerItem}} >{playerItem.Name}</Link>
                    </div>
                ))
            }
        </div>
    )
}