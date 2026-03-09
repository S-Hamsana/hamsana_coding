/*
  # Create Players Table

  1. New Tables
    - `players`
      - `player_id` (uuid, primary key) - Unique identifier for the player
      - `player_name` (text) - Name of the player
      - `jersey_number` (integer) - Jersey number of the player
      - `role` (text) - Role of the player (Batsman, Bowler, Keeper, All Rounder)
      - `total_matches` (integer) - Total matches played by the player
      - `team_name` (text) - Name of the team
      - `country_state` (text) - Country or state name
      - `description` (text) - Brief description of the player
      - `created_at` (timestamptz) - Record creation timestamp
      - `updated_at` (timestamptz) - Record update timestamp

  2. Security
    - Enable RLS on `players` table
    - Add policy for public read access
    - Add policy for public insert access
    - Add policy for public update access
    - Add policy for public delete access
*/

CREATE TABLE IF NOT EXISTS players (
  player_id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  player_name text NOT NULL,
  jersey_number integer NOT NULL,
  role text NOT NULL,
  total_matches integer DEFAULT 0,
  team_name text NOT NULL,
  country_state text NOT NULL,
  description text DEFAULT '',
  created_at timestamptz DEFAULT now(),
  updated_at timestamptz DEFAULT now()
);

ALTER TABLE players ENABLE ROW LEVEL SECURITY;

CREATE POLICY "Allow public read access"
  ON players FOR SELECT
  TO public
  USING (true);

CREATE POLICY "Allow public insert access"
  ON players FOR INSERT
  TO public
  WITH CHECK (true);

CREATE POLICY "Allow public update access"
  ON players FOR UPDATE
  TO public
  USING (true)
  WITH CHECK (true);

CREATE POLICY "Allow public delete access"
  ON players FOR DELETE
  TO public
  USING (true);