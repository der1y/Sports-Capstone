import { useLocation } from "react-router-dom"



export default function PlayerInfoView({ player: propPlayer }) {
    const location = useLocation();
    const player = propPlayer || location.state?.playerItem;

    if (!player) return <p>Player not found.</p>

    return (

        <div>
            <h1>{player?.Name}</h1>
            <ul>
                <li> Position: {player?.Position} </li>
                <li> Status: {player?.Status} </li>
                <li> Age: {player?.Age} </li>
                <li> College: {player?.College} </li>
            </ul>
        </div>
    )
}